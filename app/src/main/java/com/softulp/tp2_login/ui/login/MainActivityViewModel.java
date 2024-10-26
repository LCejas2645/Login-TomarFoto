package com.softulp.tp2_login.ui.login;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.tp2_login.modelo.Usuario;
import com.softulp.tp2_login.request.Api;
import com.softulp.tp2_login.request.ApiClient;

import java.lang.invoke.MutableCallSite;

public class MainActivityViewModel extends AndroidViewModel {

   private MutableLiveData <Usuario> usuarioMutable;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Usuario> getUsuarioMutable() {

        if(usuarioMutable == null){
            usuarioMutable = new MutableLiveData<>();
        }
        return usuarioMutable;
    }

    public void validarUsuario(String email, String password){
        Usuario usuario = Api.login(getApplication(),email,password);
        if(usuario!= null){
            usuarioMutable.setValue(usuario);
        }else{
            Toast.makeText(getApplication(),"Error, usuario o contraseña incorrecto "+email+".."+password+" usuario: "+usuario,Toast.LENGTH_LONG).show();
        }
    }
}
