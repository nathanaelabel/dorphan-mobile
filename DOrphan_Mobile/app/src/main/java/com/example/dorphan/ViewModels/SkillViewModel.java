package com.example.dorphan.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.dorphan.Models.Skill;
import com.example.dorphan.Repositories.SkillRepository;

import java.util.List;

public class SkillViewModel extends AndroidViewModel {
    private SkillRepository skillRepository;

    public SkillViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String token) {
        skillRepository = SkillRepository.getInstance(token);
    }

    //== Begin of view model to get all category
    private MutableLiveData<List<Skill.Result>> resultSkills = new MutableLiveData<>();

    public void getSkills() {
        resultSkills = skillRepository.getSkills();
    }

    public LiveData<List<Skill.Result>> getResultSkills() {
        return resultSkills;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        skillRepository.resetInstance();
    }
}
