<?php

//Created by Nur Azizah at 18 Desember 2022

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Skill extends Model
{
    use HasFactory;

    //Initialitation variable that can not be assign in skills table database
    protected $guarded = [
        'id',
    ];

    //Initialitation relation of foreign key between skills and courses table in database
    public function courses()
    {
        return $this->hasMany(Course::class);
    }
}
