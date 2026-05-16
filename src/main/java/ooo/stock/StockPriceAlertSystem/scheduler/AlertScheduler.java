package ooo.stock.StockPriceAlertSystem.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ooo.stock.StockPriceAlertSystem.service.AlertEngineService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;


@Component
@RequiredArgsConstructor
@Slf4j
public class AlertScheduler {

    private final AlertEngineService alertEngineService;

    @Scheduled(fixedDelay = 5000)
    public void runAlertCheck(){
        log.info("Running scheduled alert check");

        alertEngineService.processAlerts();
    }

}
