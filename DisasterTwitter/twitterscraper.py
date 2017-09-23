import twitter
import csv
import re


class TwitterScraper(twitter.Api):
    """
    Scraps twitter for disaster information. Stores any information in a database.
    """
    def __init__(self, config):
        super().__init__(consumer_key=config['consumer_key'],
                         consumer_secret=config['consumer_secret_key'],
                         access_token_key=config['access_token'],
                         access_token_secret=config['access_token_secret'])
        self._sconfig = config

    def search_keywords(self):
        """
        Takes a list of key word strings and searches each of them on twitter.
        """
        for keyword in self._sconfig['keywords']:
            geocode=self._sconfig['geocode']+','+ self._sconfig['radius']
            results = self.GetSearch(term=keyword,count=100,geocode=geocode)
            print(len(results))
            for x in results:
                if not x.coordinates:
                    continue
                print(x.coordinates)
                #with open("./data.csv", "a") as data:
                #    writer = csv.writer(data)
                #    writer.writerow(self.parse_status(results,keywords))


    def parse_status(self,status,keywords):
        """
        Takes a twitter.Status and parse's it for location and severity. Returns a tuple with latitude, longitude, and
        severity.
        """
        pass
