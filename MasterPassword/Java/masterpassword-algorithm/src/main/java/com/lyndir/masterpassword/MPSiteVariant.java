package com.lyndir.masterpassword;

import com.google.common.collect.ImmutableList;
import com.lyndir.lhunath.opal.system.logging.Logger;
import java.util.List;


/**
 * @author lhunath, 14-12-02
 */
public enum MPSiteVariant {
    Password( "The password to log in with.", "Doesn't currently use a context.", //
              ImmutableList.of( "p", "password" ), "com.lyndir.masterpassword" ),
    Login( "The username to log in as.", "Doesn't currently use a context.", //
           ImmutableList.of( "l", "login" ), "com.lyndir.masterpassword.login" ),
    Answer( "The answer to a security question.", "Empty for a universal site answer or\nthe most significant word(s) of the question.", //
            ImmutableList.of( "a", "answer" ), "com.lyndir.masterpassword.answer" );

    static final Logger logger = Logger.get( MPSiteType.class );

    private final String       description;
    private final String       contextDescription;
    private final List<String> options;
    private final String       scope;

    MPSiteVariant(final String description, final String contextDescription, final List<String> options, final String scope) {
        this.contextDescription = contextDescription;

        this.options = options;
        this.description = description;
        this.scope = scope;
    }

    public String getDescription() {
        return description;
    }

    public String getContextDescription() {
        return contextDescription;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getScope() {
        return scope;
    }

    /**
     * @param option The option to select a variant with.  It is matched case insensitively.
     *
     * @return The variant registered for the given option.
     */
    public static MPSiteVariant forOption(final String option) {

        for (final MPSiteVariant variant : values())
            if (variant.getOptions().contains( option.toLowerCase() ))
                return variant;

        throw logger.bug( "No variant for option: %s", option );
    }
    /**
     * @param name The name of the variant to look up.  It is matched case insensitively.
     *
     * @return The variant registered with the given name.
     */
    public static MPSiteVariant forName(final String name) {

        if (name == null)
            return null;

        for (final MPSiteVariant type : values())
            if (type.name().equalsIgnoreCase( name ))
                return type;

        throw logger.bug( "No variant for name: %s", name );
    }

}
