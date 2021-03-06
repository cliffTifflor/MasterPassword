/**
 * Copyright Maarten Billemont (http://www.lhunath.com, lhunath@lyndir.com)
 *
 * See the enclosed file LICENSE for license information (LGPLv3). If you did
 * not receive this file, see http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * @author   Maarten Billemont <lhunath@lyndir.com>
 * @license  http://www.gnu.org/licenses/lgpl-3.0.txt
 */

//
//  MPAlgorithmV0
//
//  Created by Maarten Billemont on 16/07/12.
//  Copyright 2012 lhunath (Maarten Billemont). All rights reserved.
//

#import "MPAlgorithm.h"

@interface MPAlgorithmV0 : NSObject<MPAlgorithm>

- (NSDictionary *)allCiphers;
- (NSArray *)ciphersForType:(MPSiteType)type;
- (NSArray *)cipherClasses;
- (NSArray *)cipherClassCharacters;
- (NSString *)charactersForCipherClass:(NSString *)cipherClass;

@end
