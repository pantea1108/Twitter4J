/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package examples.account;

import twitter4j.AccountSettings;
import twitter4j.Location;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Gets account settings.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
public final class GetAccountSettings {
    /**
     * Usage: java twitter4j.examples.account.GetAccountSettings
     *
     * @param args arguments doesn't take effect with this example
     */
    public static void main(String[] args) {
        try {
            var users = Twitter.getInstance().v1().users();
            AccountSettings settings = users.getAccountSettings();
            System.out.println("Sleep time enabled: " + settings.isSleepTimeEnabled());
            System.out.println("Sleep end time: " + settings.getSleepEndTime());
            System.out.println("Sleep start time: " + settings.getSleepStartTime());
            System.out.println("Geo enabled: " + settings.isGeoEnabled());
            System.out.println("Screen name: " + settings.getScreenName());
            System.out.println("Listing trend locations:");
            Location[] locations = settings.getTrendLocations();
            for (Location location : locations) {
                System.out.println(" " + location.getName());
            }
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get account settings: " + te.getMessage());
            System.exit(-1);
        }
    }
}
