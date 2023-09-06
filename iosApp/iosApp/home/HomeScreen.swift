
import SwiftUI
import shared

struct HomeScreen: View {
    @StateObject var viewModel = HomeViewModel()
    
    let gridColumns: [GridItem] = Array(repeating: GridItem(.flexible(), spacing: 16), count: 2)
 
    
    var body: some View {
        NavigationStack{

            ScrollView{
                LazyVGrid(columns: gridColumns, spacing: 16){
                    
                    ForEach(viewModel.coins, id: \.id){coins in
                        
                        NavigationLink(value: coins){
                            CoinGridItem(coin: coins)
                                .task {
                                    if coins == viewModel.coins.last && !viewModel.isLoading && !viewModel.loadFinished {
                                        await viewModel.loadMovies()
                                    }
                                }
                        }
                        .buttonStyle(PlainButtonStyle())
                    }
                    
                    if viewModel.isLoading {
                        Section(footer: ProgressView()){}
                    }
                    
                }
                .padding(.horizontal, 12)
                .navigationDestination(for: CoinRemote.self){coins in
                    DetailsScreen(coin: coins)
                }
                
            }
            .navigationTitle("Birds")
            
        }
        .task {
            await viewModel.loadMovies()
        }
    }
}

struct HomeScreen_Previews: PreviewProvider {
    static var previews: some View {
        HomeScreen()
    }
}
