<?php

//Created by Nur Azizah at 18 Desember 2022

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class CourseBooking extends Model
{
    use HasFactory;

    //Initialitation variable that can not be assign in course_bookings table database
    protected $guarded = [
        'id',
    ];

    //Initialitation relation of foreign key between course_bookings and orphanage table in database
    public function orphanage()
    {
        return $this->belongsTo(Orphanage::class);
    }

    //Initialitation relation of foreign key between course_bookings and course table in database
    public function course()
    {
        return $this->belongsTo(Course::class);
    }

    //Initialitation relation of foreign key between course_bookings and transaction table in database
    public function transaction()
    {
        return $this->belongsTo(Transaction::class);
    }
}
