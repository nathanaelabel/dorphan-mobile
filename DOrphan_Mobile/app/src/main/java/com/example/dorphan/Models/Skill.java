package com.example.dorphan.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class Skill implements Parcelable {

    private List<Result> result;

    protected Skill(Parcel in) {
    }

    public static final Creator<Skill> CREATOR = new Creator<Skill>() {
        @Override
        public Skill createFromParcel(Parcel in) {
            return new Skill(in);
        }

        @Override
        public Skill[] newArray(int size) {
            return new Skill[size];
        }
    };

    public static Skill objectFromData(String str) {

        return new Gson().fromJson(str, Skill.class);
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public static class Result {
        private int id;
        private String name;
        private Object photo_path;
        private List<Courses> courses;
        private String created_at;
        private String updated_at;

        public static Result objectFromData(String str) {

            return new Gson().fromJson(str, Result.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getPhoto_path() {
            return photo_path;
        }

        public void setPhoto_path(Object photo_path) {
            this.photo_path = photo_path;
        }

        public List<Courses> getCourses() {
            return courses;
        }

        public void setCourses(List<Courses> courses) {
            this.courses = courses;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public static class Courses {
            private int id;
            private int tutor_id;
            private int skill_id;
            private String description;
            private String location;
            private int is_online;
            private int is_visit;
            private int maximum_member;
            private int tool_price;
            private String tool_description;
            private String start_time;
            private String day;
            private int price_sum;
            private int hour_sum;
            private String created_at;
            private String updated_at;

            public static Courses objectFromData(String str) {

                return new Gson().fromJson(str, Courses.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getTutor_id() {
                return tutor_id;
            }

            public void setTutor_id(int tutor_id) {
                this.tutor_id = tutor_id;
            }

            public int getSkill_id() {
                return skill_id;
            }

            public void setSkill_id(int skill_id) {
                this.skill_id = skill_id;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getLocation() {
                return location;
            }

            public void setLocation(String location) {
                this.location = location;
            }

            public int getIs_online() {
                return is_online;
            }

            public void setIs_online(int is_online) {
                this.is_online = is_online;
            }

            public int getIs_visit() {
                return is_visit;
            }

            public void setIs_visit(int is_visit) {
                this.is_visit = is_visit;
            }

            public int getMaximum_member() {
                return maximum_member;
            }

            public void setMaximum_member(int maximum_member) {
                this.maximum_member = maximum_member;
            }

            public int getTool_price() {
                return tool_price;
            }

            public void setTool_price(int tool_price) {
                this.tool_price = tool_price;
            }

            public String getTool_description() {
                return tool_description;
            }

            public void setTool_description(String tool_description) {
                this.tool_description = tool_description;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getDay() {
                return day;
            }

            public void setDay(String day) {
                this.day = day;
            }

            public int getPrice_sum() {
                return price_sum;
            }

            public void setPrice_sum(int price_sum) {
                this.price_sum = price_sum;
            }

            public int getHour_sum() {
                return hour_sum;
            }

            public void setHour_sum(int hour_sum) {
                this.hour_sum = hour_sum;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdated_at() {
                return updated_at;
            }

            public void setUpdated_at(String updated_at) {
                this.updated_at = updated_at;
            }
        }
    }
}
