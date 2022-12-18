<?php

//Created by Nur Azizah at 18 Desember 2022

namespace App\Models;

//use Illuminate\Contracts\Auth\MustVerifyEmail;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;
use Laravel\Passport\HasApiTokens;

class User extends Authenticatable
{
    use HasApiTokens;
    use HasFactory;
    use Notifiable;

    /**
     * The attributes that are mass assignable.
     *
     * @var array<int, string>
     */

    //Initialitation variable that can not be assign in users table database
    protected $guarded = [
        'id',
    ];

    //Initialitation relation of foreign key between users and transactions table in database
    public function transactions()
    {
        return $this->hasMany(Transaction::class, 'user_id');
    }

    //Initialitation relation of foreign key between users and tutors table in database
    public function tutor()
    {
        return $this->hasOne(Tutor::class);
    }

    //Initialitation relation of foreign key between users and orphanages table in database
    public function orphanage()
    {
        return $this->hasOne(Orphanage::class);
    }

    /**
     * The attributes that should be hidden for serialization.
     *
     * @var array<int, string>
     */
    protected $hidden = [
        'password',
        'remember_token',
    ];

    /**
     * The attributes that should be cast.
     *
     * @var array<string, string>
     */
    protected $casts = [
        'email_verified_at' => 'datetime',
    ];
}
