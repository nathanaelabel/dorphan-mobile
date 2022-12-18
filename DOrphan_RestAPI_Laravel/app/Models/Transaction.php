<?php

//Created by Nur Azizah at 18 Desember 2022

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Transaction extends Model
{
    use HasFactory;

    //Initialitation variable that can not be assign in transactions table database
    protected $guarded = [
        'id',
    ];

    //Initialitation relation of foreign key between transactions and users table in database
    public function user()
    {
        return $this->belongsTo(User::class);
    }
}
