<?php

//Created by Nur Azizah at 18 Desember 2022

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Orphan extends Model
{
    use HasFactory;

    //Initialitation variable that can not be assign in orphans table database
    protected $guarded = [
        'id',
    ];

    //Initialitation relation of foreign key between orphans and orphanages table in database
    public function orphanage()
    {
        return $this->belongsTo(Orphanage::class);
    }
}
