package com.example.dorphan.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.example.dorphan.Repositories.SkillRepository;

public class SkillViewModel extends AndroidViewModel {
    private SkillRepository skillRepository;

    public SkillViewModel(@NonNull Application application) {
        super(application);
    }

    public void init(String token) {
        skillRepository = SkillRepository.getInstance(token);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        skillRepository.resetInstance();
    }
}
