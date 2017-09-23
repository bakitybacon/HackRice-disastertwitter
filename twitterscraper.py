import twitter
import csv
import re


class TwitterScraper(twitter.Api):
    """
    Scraps twitter for disaster information. Stores any information in a database.
    """
    def __init__(self, consumer_key, consumer_secret, access_token_key,access_token_secret):
        super().__init__(consumer_key=consumer_key,
                         consumer_secret=consumer_secret,
                         access_token_key=access_token_key,
                         access_token_secret=access_token_secret)

    def search_keywords(self,keywords,geocode):
        """
        Takes a list of key word strings and searches each of them on twitter.
        """

        results = self.GetSearch(term=keywords[0],geocode=geocode,count=25)
        with open("./data.csv", "a") as data:
            writer = csv.writer(data)
            writer.writerow(self.parse_status(results,keywords))


    def parse_status(self,status,keywords):
        """
        Takes a twitter.Status and parse's it for location and severity. Returns a tuple with latitude, longitude, and
        severity.
        """
        pass
