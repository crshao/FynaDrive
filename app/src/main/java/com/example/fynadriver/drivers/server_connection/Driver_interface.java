package com.example.fynadriver.drivers.server_connection;

import com.example.fynadriver.drivers.server_connection.login_bagian1.ExampleLoginDriver;
import com.example.fynadriver.drivers.server_connection.login_bagian1.ExampleLoginDriver2;
import com.example.fynadriver.drivers.server_connection.login_bagian1.ResultLogin2;
import com.example.fynadriver.drivers.server_connection.register_bagian2.ExampleRegister2;
import com.example.fynadriver.drivers.server_connection.register_bagian_1.ExampleRegister1;
import com.example.fynadriver.users.server_connection_user.ExampleLogin;
import com.example.fynadriver.users.server_connection_user.ExampleUser;
import com.example.fynadriver.users.server_connection_user.UserPojo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Driver_interface {
    @FormUrlEncoded
    @POST("authfifi/driver_bag1.php")
    Call<ExampleRegister1> postingDriver1(@Field("REG1_NAMA") String nama,
                                          @Field("REG1_TTL") String ttl,
                                          @Field("REG1_JENIS_KEL") String kelamin,
                                          @Field("REG1_PHONE") String phone);

    @FormUrlEncoded
    @POST("authfifi/driver_bag2.php")
    Call<ExampleRegister2> postingDriver2(@Field("REG2_PASSWORD") String password,
                                          @Field("REG2_KENDARAAN") String kendaraan,
                                          @Field("REG2_PLAT_NOMOR") String plat_nomor);

    @FormUrlEncoded
    @POST("authfifi/login.php")
    Call<ExampleLoginDriver> postingDriver3(@Field("REG2_PASSWORD") String password);

    @FormUrlEncoded
    @POST("authfifi/register3.php")
    Call<ExampleUser> postingUser(@Field("nama_user") String nama,
                                  @Field("email_user") String email,
                                  @Field("phone_user") String phone,
                                  @Field("password_fifi") String password);

    @FormUrlEncoded
    @POST("authfifi/login3.php")
    Call<ExampleLogin> loginUser(@Field("phone_user") String phone,
                                 @Field("password_fifi") String password);
}
