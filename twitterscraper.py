import twitter

class TwitterScraper(twitter.Api):
    """
    Scraps twitter for disaster information. Stores any information in a database.
    """
    def __init__(self,consumer_key,consumer_secret,access_token_key,access_token_secret):
        super().__init__(consumer_key=consumer_key,
                         consumer_secret=consumer_secret,
                         access_token_key=access_token_key,
                         access_token_secret=access_token_secret)
		