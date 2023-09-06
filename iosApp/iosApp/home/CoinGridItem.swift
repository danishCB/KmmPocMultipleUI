//
//  CoinGridItem.swift
//  iosApp
//
//  Created by Danish Hassan on 30/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//


import SwiftUI
import shared

struct CoinGridItem: View {
    let coin: CoinRemote
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8){
            ZStack{
                AsyncImage(url: URL(string: coin.url ?? "")){image in
                    image.resizable()
                }placeholder: {
                    Color.gray
                }
                
            }
            .frame(maxWidth: .infinity, idealHeight: .infinity)
            .clipShape(RoundedRectangle(cornerRadius: 8))
            
            Text(coin.title ?? "")
                .font(.title3)
                .fontWeight(.bold)
                .lineLimit(1)
            
            Text(coin.description_ ?? "")
                .font(.caption)
                .lineLimit(4)
            
            
        }
        .frame(maxWidth: .infinity, maxHeight: 260)
    }
}

struct MovieGridItem_Previews: PreviewProvider {
    static var previews: some View {
        CoinGridItem(coin: sampleCoin)
    }
}
