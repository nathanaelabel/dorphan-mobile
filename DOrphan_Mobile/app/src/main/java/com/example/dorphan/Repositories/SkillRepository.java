package com.example.dorphan.Repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.dorphan.Models.Skill;
import com.example.dorphan.Retrofit.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillRepository {
    private static SkillRepository skillRepository;
    private ApiService apiService;

    private SkillRepository(String token) {
        apiService = ApiService.getInstance(token);
    }

    public static SkillRepository getInstance(String token) {
        if (skillRepository == null) {
            skillRepository = new SkillRepository(token);
        }
        return skillRepository;
    }

    public static synchronized void resetInstance() {
        if (skillRepository != null) {
            skillRepository = null;
        } else {
            skillRepository = null;
        }
    }

    public MutableLiveData<List<Skill.Result>> getSkills() {
        final MutableLiveData<List<Skill.Result>> listSkills = new MutableLiveData<>();

        apiService.getSkills().enqueue(new Callback<Skill>() {
            @Override
            public void onResponse(Call<Skill> call, Response<Skill> response) {
                if (response.isSuccessful()) {
                    listSkills.postValue(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<Skill> call, Throwable t) {
            }
        });

        return listSkills;
    }
}