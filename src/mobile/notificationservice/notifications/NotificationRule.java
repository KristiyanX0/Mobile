package mobile.notificationservice.notifications;

import mobile.notificationservice.channels.NotificationChannel;
import mobile.notificationservice.listing.Listing;
import mobile.search.Filter;

import java.util.List;

public record NotificationRule (
    List<Filter<Listing>> filter,
    NotificationChannel channel
) {}
