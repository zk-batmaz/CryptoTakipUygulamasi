package com.qbra.retrofitjava.service;

import com.qbra.retrofitjava.model.CryptoModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {

    //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    //Call<List<CryptoModel>> getData();
    Observable<List<CryptoModel>> getData();
}
