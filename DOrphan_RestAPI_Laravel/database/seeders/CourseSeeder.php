<?php

//Created by Nur Azizah at 18 Desember 2022

namespace Database\Seeders;

use App\Models\Course;
use App\Models\Tutor;
use Illuminate\Database\Seeder;

class CourseSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        //Looping all tutor datas for assign course data
        foreach (Tutor::all() as $tutor) {
            Course::factory()->count(random_int(1, 5))->create([
                'tutor_id' => $tutor->id,
            ]);
        }
    }
}
