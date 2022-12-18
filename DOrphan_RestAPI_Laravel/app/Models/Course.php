<?php

//Created by Nur Azizah at 18 Desember 2022

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Course extends Model
{
    use HasFactory;

    //Initialitation variable that can not be assign in courses table database
    protected $guarded = [
        'id',
    ];

    //Initialitation relation of foreign key between courses and tutors table in database
    public function tutor()
    {
        return $this->belongsTo(Tutor::class);
    }

    //Initialitation relation of foreign key between courses and skills table in database
    public function skill()
    {
        return $this->belongsTo(Skill::class);
    }

    //Initialitation relation of foreign key between courses and course_bookings table in database
    public function courseBookings()
    {
        return $this->hasMany(CourseBooking::class);
    }
}
