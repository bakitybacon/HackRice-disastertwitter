

class ConfigParser:

    def __init__(self):
        pass

    @staticmethod
    def parse_file(parsefile):
        dictionary = {}
        keyword_dictionary = {}
        adding_keywords = False
        with open(parsefile,'r') as file:
            for line in file.readlines():
                if line[:2] == "//":
                    continue
                if line[0] == "#":
                    adding_keywords = True
                    continue
                if line.isspace():
                    continue
                try:
                    variable,value = line.split('=')
                except ValueError:
                    raise ValueError("Invalid configuration line: {0}".format(line))
                if adding_keywords:
                    keyword_dictionary[variable] = int(value)
                else:
                    dictionary[variable] = value[:-1]
        dictionary["keywords"] = keyword_dictionary
        return dictionary
