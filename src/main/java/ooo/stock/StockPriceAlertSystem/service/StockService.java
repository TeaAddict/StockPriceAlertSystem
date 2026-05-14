package ooo.stock.StockPriceAlertSystem.service;

import lombok.AllArgsConstructor;

import ooo.stock.StockPriceAlertSystem.dto.StockRequest;
import ooo.stock.StockPriceAlertSystem.exception.ResourceNotFoundException;
import ooo.stock.StockPriceAlertSystem.model.Stock;
import ooo.stock.StockPriceAlertSystem.model.User;
import ooo.stock.StockPriceAlertSystem.repository.StockRepository;
import ooo.stock.StockPriceAlertSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StockService {

    private final StockRepository stockRepository;
    private final UserRepository userRepository;

    public List<Stock> getStocks(){
        return stockRepository.findAll();
    }

//    public Stock createStock(StockRequest stockRequest){
//        User user = userRepository.findById(stockRequest.userId()).orElseThrow(() -> new ResourceNotFoundException("User does not exist"));
//
//        Stock stock = new Stock(stockRequest.label());
//        stock.setUser(user);
//        stockRepository.save(stock);
//        return stock;
//    }

//    public Stock getStock(Long stockId){
//        return stockRepository.findById(stockId).orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
//    }

//    public Stock updateStock(Long stockId, StockRequest stockRequest){
//        Stock stock = stockRepository.findById(stockId).orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
//        User user = userRepository.findById(stockRequest.userId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
//        stock.setLabel(stockRequest.label());
//        stock.setUser(user);
//        stockRepository.save(stock);
//        return stock;
//    }
//
//    public void deleteStock(Long stockId){
//        Stock stock = stockRepository.findById(stockId).orElseThrow(() -> new ResourceNotFoundException("Stock not found"));
//        stockRepository.deleteById(stockId);
//    }

}
