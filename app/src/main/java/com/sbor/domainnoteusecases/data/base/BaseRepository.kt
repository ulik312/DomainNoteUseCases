package com.sbor.domainnoteusecases.data.base

import com.sbor.domainnoteusecases.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

abstract class BaseRepository {
    protected fun <T> doRequest( request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(request))

        }catch (ioExeption : IOException){
            emit(Resource.Error(ioExeption.localizedMessage ?:"Unknown error!"))
        }

    }.flowOn(Dispatchers.IO)

}