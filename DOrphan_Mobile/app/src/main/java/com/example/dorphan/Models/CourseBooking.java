package com.example.dorphan.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.util.List;

public class CourseBooking implements Parcelable {

    private List<Result> result;

    protected CourseBooking(Parcel in) {
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<CourseBooking> CREATOR = new Creator<CourseBooking>() {
        @Override
        public CourseBooking createFromParcel(Parcel in) {
            return new CourseBooking(in);
        }

        @Override
        public CourseBooking[] newArray(int size) {
            return new CourseBooking[size];
        }
    };

    public static CourseBooking objectFromData(String str) {

        return new Gson().fromJson(str, CourseBooking.class);
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public static class Result {
        private int id;
        private Course course;
        private Tutor tutor;
        private TutorUser tutor_user;
        private Skill skill;
        private Transaction transaction;
        private Orphanage orphanage;
        private OrphanageUser orphanage_user;
        private String status;
        private int member_sum;
        private String location;
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

        public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
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

        public Transaction getTransaction() {
            return transaction;
        }

        public void setTransaction(Transaction transaction) {
            this.transaction = transaction;
        }

        public Orphanage getOrphanage() {
            return orphanage;
        }

        public void setOrphanage(Orphanage orphanage) {
            this.orphanage = orphanage;
        }

        public OrphanageUser getOrphanage_user() {
            return orphanage_user;
        }

        public void setOrphanage_user(OrphanageUser orphanage_user) {
            this.orphanage_user = orphanage_user;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getMember_sum() {
            return member_sum;
        }

        public void setMember_sum(int member_sum) {
            this.member_sum = member_sum;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
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

        public static class Course {
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
            private Tutor tutor;
            private Skill skill;

            public static Course objectFromData(String str) {

                return new Gson().fromJson(str, Course.class);
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

            public Tutor getTutor() {
                return tutor;
            }

            public void setTutor(Tutor tutor) {
                this.tutor = tutor;
            }

            public Skill getSkill() {
                return skill;
            }

            public void setSkill(Skill skill) {
                this.skill = skill;
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

        public static class Transaction {
            private int id;
            private int user_id;
            private int amount;
            private String status;
            private String description;
            private int to_user_id;
            private String created_at;
            private String updated_at;

            public static Transaction objectFromData(String str) {

                return new Gson().fromJson(str, Transaction.class);
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

            public int getAmount() {
                return amount;
            }

            public void setAmount(int amount) {
                this.amount = amount;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getTo_user_id() {
                return to_user_id;
            }

            public void setTo_user_id(int to_user_id) {
                this.to_user_id = to_user_id;
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

        public static class Orphanage {
            private int id;
            private String name;
            private String photo_url;
            private String description;
            private int user_id;
            private String created_at;
            private String updated_at;
            private User user;

            public static Orphanage objectFromData(String str) {

                return new Gson().fromJson(str, Orphanage.class);
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

            public String getPhoto_url() {
                return photo_url;
            }

            public void setPhoto_url(String photo_url) {
                this.photo_url = photo_url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
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

        public static class OrphanageUser {
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

            public static OrphanageUser objectFromData(String str) {

                return new Gson().fromJson(str, OrphanageUser.class);
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
}
