//
//  DetailScreen.swift
//  iosApp
//
//  Created by Danish Hassan on 30/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//


import SwiftUI
import shared

struct DetailsScreen: View {
    let coin: CoinRemote
    
    var body: some View {
        ScrollView{
            
            VStack{
                
                ZStack{
                    AsyncImage(url: URL(string: coin.url ?? "")){image in
                        image.resizable().scaledToFill()
                    }placeholder: {
                        ProgressView()
                    }
                }
                .frame(maxWidth: .infinity, minHeight: 300, maxHeight: 300)
                .padding(20)
                .background(.black)
                
                Text(coin.title ?? "")
                    .font(.title3)
                    .fontWeight(.bold)
                    .lineLimit(1)
                
                Text(coin.description_ ?? "")
                    .font(.caption)
                    .lineLimit(4)
                
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity)
            
        }
    }
}

struct DetailScreen_Previews: PreviewProvider {
    static var previews: some View {
        DetailsScreen(coin: sampleCoin)
    }
}
