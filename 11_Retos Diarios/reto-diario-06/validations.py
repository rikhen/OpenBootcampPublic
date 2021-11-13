from directories import strings


def is_string(string):
    res = type(string)
    if res == str:
        return True
    else:
        return False


def is_exists(value):
    if value in strings:
        return True
    else:
        return False