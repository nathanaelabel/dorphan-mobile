<?php

//Created by Nur Azizah at 18 Desember 2022

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Tutor extends Model
{
    use HasFactory;

    //Initialitation variable that can not be assign in tutors table database
    protected $guarded = [
        'id',
    ];

    //Initialitation relation of foreign key between tutors and courses table in database
    public function courses()
    {
        return $this->hasMany(Course::class);
    }

    //Initialitation relation of foreign key between tutors and course_bookings table in database
    public function courseBookings()
    {
        return $this->hasMany(CourseBooking::class);
    }

    //Initialitation relation of foreign key between tutors and users table in database
    public function user()
    {
        return $this->belongsTo(User::class);
    }
}
