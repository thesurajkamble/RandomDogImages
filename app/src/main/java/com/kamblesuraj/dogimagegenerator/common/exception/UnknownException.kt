package com.kamblesuraj.dogimagegenerator.common.exception

import com.kamblesuraj.dogimagegenerator.common.utils.Constants.NO_INTERNET_EXCEPTION
import com.kamblesuraj.dogimagegenerator.common.utils.Constants.UNKNOWN_ERROR

class UnknownException: Exception(UNKNOWN_ERROR)
class NoInternetException: Exception(NO_INTERNET_EXCEPTION)