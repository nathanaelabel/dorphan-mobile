package com.example.dorphan.Repositories;

import com.example.dorphan.Retrofit.ApiService;

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
}
