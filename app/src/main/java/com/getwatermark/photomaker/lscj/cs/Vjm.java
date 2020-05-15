package com.getwatermark.photomaker.lscj.cs;

import com.getwatermark.photomaker.lscj.cs.wc.Lci;
import com.getwatermark.photomaker.lscj.cs.wc.Spco;
import com.getwatermark.photomaker.lscj.cs.wc.Vxjz;
import com.getwatermark.photomaker.lscj.cs.wc.Wcxj;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * @author Afra55
 * @date 2018/4/17
 * A smile is the best business card.
 */
public interface Vjm {

    @GET("http://ip-api.com/json")
    Observable<Vxjz> getIpInfoTwo();

    @GET("http://ip-api.com/json")
    Observable<Wcxj> getIpInfoThree();

    @POST("api/misc/clientevent")
    Observable<Lci> uploadIpInfo(@QueryMap Map<String, Object> map, @Body Object data);

    @GET("/vci")
    Observable<String> cfg(@QueryMap Map<String, Object> map);

    @GET("androidpluginapi/get")
    Observable<Spco> getPpInfo(@QueryMap Map<String, Object> map);
}
