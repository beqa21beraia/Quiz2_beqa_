package com.example.mobileapplications22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileapplications22.OnBoarding.SignUpFragment
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.placeHolder,SignUpFragment.newInstance()).commit()
    }
}

val database = FirebaseDatabase.getInstance()
val postsRef = database.getReference("posts")

postsRef.get().addOnSuccessListener { snapshot ->
    if (snapshot.exists()) {
        for (child in snapshot.children) {
            val post = child.getValue(Post::class.java) // Convert data to Post object
            if (post != null) {
                println(post) // Display or process the post
            }
        }
    } else {
        println("No posts found")
    }
}.addOnFailureListener { exception ->
    println("Error: ${exception.message}")
}
