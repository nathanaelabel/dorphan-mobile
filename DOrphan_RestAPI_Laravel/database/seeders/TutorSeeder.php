<?php

//Created by Nur Azizah at 18 Desember 2022

namespace Database\Seeders;

use App\Models\Tutor;
use App\Models\User;
use Illuminate\Database\Seeder;

class TutorSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        //Create tutor data
        foreach (User::all()->where('user_type', 'Tutor') as $user) {
            Tutor::factory()->create([
                'user_id' => $user->id,
            ]);
        }
    }
}
