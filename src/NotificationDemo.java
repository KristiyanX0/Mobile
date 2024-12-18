
import mobile.notificationservice.channels.SmsNotificationChannel;
import mobile.notificationservice.external.SmsNotifier;
import mobile.notificationservice.listing.Listing;
import mobile.notificationservice.listing.ListingService;
import mobile.notificationservice.listing.ListingStorage;
import mobile.notificationservice.notifications.NotificationRule;
import mobile.notificationservice.notifications.NotificationService;
import mobile.search.ExactValueFilter;
import mobile.search.RangeFilter;
import mobile.vehicles.Car;

import java.util.List;

public class NotificationDemo {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        ListingService listingService = new ListingService(new ListingStorage(), notificationService);

        notificationService.subscribe(
                new NotificationRule(
                        List.of(
                                new ExactValueFilter<>(listing -> listing.getCar().brand(), "Toyota"),
                                new RangeFilter<>(Listing::getPrice, 10000, 20000)
                        ),
                        new SmsNotificationChannel(new SmsNotifier(), "+359888888888")
                )
        );

        listingService.addListing(new Listing(
                "Hubava Toyota, nov vnos",
                15000,
                new Car(
                        "Toyota",
                        "Corolla",
                        2021,
                        true
                )
        ));
    }
}