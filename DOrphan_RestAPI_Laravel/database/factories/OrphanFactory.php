<?php

//Created by Nur Azizah at 18 Desember 2022

namespace Database\Factories;

use Illuminate\Database\Eloquent\Factories\Factory;
use Faker\Factory as Faker;

/**
 * @extends \Illuminate\Database\Eloquent\Factories\Factory<\App\Models\Orphan>
 */
class OrphanFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition()
    {
        $faker = Faker::create('id_ID');
        $min = strtotime('47 years ago');
        $max = strtotime('18 years ago');
        $randTime = mt_rand($min, $max);
        $randGender = $faker->randomElement(['Male', 'Female']);
        $birthDate = date('Y-m-d H:i:s', $randTime);

        return [
            'name' => $randGender == 'Male' ? $faker->firstNameMale() : $faker->firstNameFemale(),
            'date_of_birth' => $birthDate,
            'gender' => $randGender,
            'note' => random_int(1, 2) == 1 ? 'Anak Disabilitas' : '',
        ];
    }
}
