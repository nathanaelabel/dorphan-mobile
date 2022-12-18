<?php

//Created by Nur Azizah at 18 Desember 2022

namespace Database\Seeders;

use App\Models\CourseBooking;
use App\Models\Orphanage;
use App\Models\Transaction;
use Illuminate\Database\Seeder;

class CourseBookingSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        //Looping all orphanage datas for assign course booking data
        foreach (Orphanage::all() as $orphanage) {
            CourseBooking::factory()->count(random_int(1, 5))->create([
                'orphanage_id' => $orphanage->id,
            ]);
        }

        //Looping all orphanage datas for assign coursebooking data
        foreach (CourseBooking::all() as $courseBooking) {
            if ($courseBooking->status == 'ongoing') {
                //money minus
                $status = 'complete';
            } elseif ($courseBooking->status == 'canceled') {
                //return money
                $status = 'canceled';
            } else {
                //money not yet decrease
                $status = 'pending';
            }

            //Create transaction history from course booking
            $courseBooking->transaction_id = Transaction::create([
                'user_id' => $courseBooking->orphanage->user->id,
                'amount' => $courseBooking->course->hourly_price + $courseBooking->course->tool_price,
                'status' => $status,
                'description' => 'Pembayaran kursus oleh '.$courseBooking->orphanage->name,
                'to_user_id' => $courseBooking->course->tutor->user->id,
            ])->id;
            $courseBooking->save();
        }
    }
}
