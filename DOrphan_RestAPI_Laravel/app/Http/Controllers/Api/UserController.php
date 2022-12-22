<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Http\Resources\UserResource;
use App\Models\User;

class UserController extends Controller
{
    public function index()
    {
        return ['result' => UserResource::collection(User::where('id', auth()->user()->id)->get())];
    }
}
