package ru.sergei.komarov.bikesharingsupport.common;

import ru.sergei.komarov.bikesharingsupport.models.Order;
import ru.sergei.komarov.bikesharingsupport.models.Tariff;
import ru.sergei.komarov.bikesharingsupport.models.TimeUnit;

import java.time.LocalDateTime;

public class Utils {

    public static int getCost(Order order) {
        Tariff tariff = order.getTariff();
        TimeUnit timeUnit = tariff.getTimeUnit();
        LocalDateTime startTime = order.getStartTime();
        LocalDateTime endTime = order.getEndTime();

        switch (tariff.getName()) {
            case "Эконом":
                return (int)(157 * tariff.getPricePerTimeUnit());
            case "Комфорт":
                return (int)(2 * tariff.getPricePerTimeUnit());
            case "Travel":
                return (int)(4 * tariff.getPricePerTimeUnit());
        }

        return 0;
    }

}
