//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Danish Hassan on 30/08/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

extension HomeScreen{
    
    @MainActor class HomeViewModel: ObservableObject{
    
        private let getImagesUseCase = GetCoinsUseCase.init()
        
        @Published private(set) var coins:[CoinRemote] = []
        @Published private(set) var isLoading: Bool = false
        
        private var currentPage = 1
        private(set) var loadFinished: Bool = false
       
        func loadMovies() async {
            if isLoading {
                return
            }
            
            do {
                
                let coins = try await getImagesUseCase.invoke()
                isLoading = false
                loadFinished = coins.isEmpty
                
                currentPage += 1
                
                self.coins = self.coins + coins
                
                print(self.coins)
            } catch {
                isLoading = false
                loadFinished = true
                
                print(error.localizedDescription)
            }
        }

    }
    
}
