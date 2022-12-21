package com.example.dorphan.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class Course implements Parcelable {

    private List<Result> result;

    protected Course(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Course> CREATOR = new Creator<Course>() {
        @Override
        public Course createFromParcel(Parcel in) {
            return new Course(in);
        }

        @Override
        public Course[] newArray(int size) {
            return new Course[size];
        }
    };

    public static Course objectFromData(String str) {

        return new Gson().fromJson(str, Course.class);
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public static class Result {
        private int id;
        private Tutor tutor;
        private TutorUser tutor_user;
        private Skill skill;
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

        public static Result objectFromData(String str) {

            return new Gson().fromJson(str, Result.class);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Tutor getTutor() {
            return tutor;
        }

        public void setTutor(Tutor tutor) {
            this.tutor = tutor;
        }

        public TutorUser getTutor_user() {
            return tutor_user;
        }

        public void setTutor_user(TutorUser tutor_user) {
            this.tutor_user = tutor_user;
        }

        public Skill getSkill() {
            return skill;
        }

        public void setSkill(Skill skill) {
            this.skill = skill;
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

        public static class Tutor {
            private int id;
            private int user_id;
            private String bank_account;
            private String description;
            private String created_at;
            private String updated_at;
            private User user;

            public static Tutor objectFromData(String str) {

                return new Gson().fromJson(str, Tutor.class);
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getBank_account() {
                return bank_account;
            }

            public void setBank_account(String bank_account) {
                this.bank_account = bank_account;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
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

            public User getUser() {
                return user;
            }

            public void setUser(User user) {
                this.user = user;
            }

            public static class User {
                private int id;
                private String name;
                private String email;
                private int money;
                private String phone_number;
                private String is_active;
                private String is_login;
                private String gender;
                private String user_type;
                private String email_verified_at;
                private Object profile_photo_path;
                private String address;
                private String created_at;
                private String updated_at;

                public static User objectFromData(String str) {

                    return new Gson().fromJson(str, User.class);
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

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public int getMoney() {
                    return money;
                }

                public void setMoney(int money) {
                    this.money = money;
                }

                public String getPhone_number() {
                    return phone_number;
                }

                public void setPhone_number(String phone_number) {
                    this.phone_number = phone_number;
                }

                public String getIs_active() {
                    return is_active;
                }

                public void setIs_active(String is_active) {
                    this.is_active = is_active;
                }

                public String getIs_login() {
                    return is_login;
                }

                public void setIs_login(String is_login) {
                    this.is_login = is_login;
                }

                public String getGender() {
                    return gender;
                }

                public void setGender(String gender) {
                    this.gender = gender;
                }

                public String getUser_type() {
                    return user_type;
                }

                public void setUser_type(String user_type) {
                    this.user_type = user_type;
                }

                public String getEmail_verified_at() {
                    return email_verified_at;
                }

                public void setEmail_verified_at(String email_verified_at) {
                    this.email_verified_at = email_verified_at;
                }

                public Object getProfile_photo_path() {
                    return profile_photo_path;
                }

                public void setProfile_photo_path(Object profile_photo_path) {
                    this.profile_photo_path = profile_photo_path;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
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

        public static class TutorUser {
            private int id;
            private String name;
            private String email;
            private int money;
            private String phone_number;
            private String is_active;
            private String is_login;
            private String gender;
            private String user_type;
            private String email_verified_at;
            private Object profile_photo_path;
            private String address;
            private String created_at;
            private String updated_at;

            public static TutorUser objectFromData(String str) {

                return new Gson().fromJson(str, TutorUser.class);
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

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public String getPhone_number() {
                return phone_number;
            }

            public void setPhone_number(String phone_number) {
                this.phone_number = phone_number;
            }

            public String getIs_active() {
                return is_active;
            }

            public void setIs_active(String is_active) {
                this.is_active = is_active;
            }

            public String getIs_login() {
                return is_login;
            }

            public void setIs_login(String is_login) {
                this.is_login = is_login;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getUser_type() {
                return user_type;
            }

            public void setUser_type(String user_type) {
                this.user_type = user_type;
            }

            public String getEmail_verified_at() {
                return email_verified_at;
            }

            public void setEmail_verified_at(String email_verified_at) {
                this.email_verified_at = email_verified_at;
            }

            public Object getProfile_photo_path() {
                return profile_photo_path;
            }

            public void setProfile_photo_path(Object profile_photo_path) {
                this.profile_photo_path = profile_photo_path;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
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

        public static class Skill {
            private int id;
            private String name;
            private Object photo_path;
            private String created_at;
            private String updated_at;

            public static Skill objectFromData(String str) {

                return new Gson().fromJson(str, Skill.class);
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
