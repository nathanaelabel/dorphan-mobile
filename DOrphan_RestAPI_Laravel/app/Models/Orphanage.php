<?php

//Created by Nur Azizah at 18 Desember 2022

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Orphanage extends Model
{
    use HasFactory;

    //Initialitation variable that can not be assign in orphanages table database
    protected $guarded = [
        'id',
    ];

    //Initialitation relation of foreign key between orphanages and orphans table in database
    public function orphans()
    {
        return $this->hasMany(Orphan::class);
    }

    //Initialitation relation of foreign key between orphanages and users table in database
    public function user()
    {
        return $this->belongsTo(User::class);
    }

    //Initialitation relation of foreign key between orphanages and course_bookings table in database
    public function courseBookings()
    {
        return $this->hasMany(CourseBooking::class);
    }
}
