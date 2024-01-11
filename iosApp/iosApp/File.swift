//
//  File.swift
//  iosApp
//
//  Created by Hussein Kamal on 11/01/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

extension Image {
    init(resource : KeyPath<SharedRes.images,ImageResource>){
        self.init(UIImage: SharedRes.images()[KeyPath: resource].toUIImage()!)
    }
}
