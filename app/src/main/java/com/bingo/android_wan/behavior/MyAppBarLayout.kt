package com.bingo.android_wan.behavior

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout

class MyAppBarLayout @JvmOverloads constructor(
    @NonNull context: Context,
    @Nullable attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppBarLayout(context, attrs, defStyleAttr) {


    override fun getBehavior(): CoordinatorLayout.Behavior<AppBarLayout> {
        return My()
    }

    class My : AppBarLayout.Behavior() {

        override fun onInterceptTouchEvent(
            parent: CoordinatorLayout,
            child: AppBarLayout,
            ev: MotionEvent
        ): Boolean {
            Log.d("MyAppBarLayout", "onInterceptTouchEvent: ev = $ev")

            return super.onInterceptTouchEvent(parent, child, ev)
        }

        override fun onTouchEvent(
            parent: CoordinatorLayout,
            child: AppBarLayout,
            ev: MotionEvent
        ): Boolean {
            Log.d("MyAppBarLayout", "onTouchEvent: ev = $ev")

            return super.onTouchEvent(parent, child, ev)
        }




        override fun onNestedPreScroll(
            coordinatorLayout: CoordinatorLayout,
            child: AppBarLayout,
            target: View,
            dx: Int,
            dy: Int,
            consumed: IntArray,
            type: Int
        ) {
            super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)

            Log.d(
                "MyAppBarLayout",
                "onNestedPreScroll: velocityX = $dx dx = $dx consumed = $consumed"
            )

        }


        override fun onStartNestedScroll(
            parent: CoordinatorLayout,
            child: AppBarLayout,
            directTargetChild: View,
            target: View,
            nestedScrollAxes: Int,
            type: Int
        ): Boolean {

            Log.d(
                "MyAppBarLayout",
                "onStartNestedScroll: "
            )

            return super.onStartNestedScroll(
                parent,
                child,
                directTargetChild,
                target,
                nestedScrollAxes,
                type
            )
        }


        override fun onNestedScroll(
            coordinatorLayout: CoordinatorLayout,
            child: AppBarLayout,
            target: View,
            dxConsumed: Int,
            dyConsumed: Int,
            dxUnconsumed: Int,
            dyUnconsumed: Int,
            type: Int,
            consumed: IntArray
        ) {
            super.onNestedScroll(
                coordinatorLayout,
                child,
                target,
                dxConsumed,
                dyConsumed,
                dxUnconsumed,
                dyUnconsumed,
                type,
                consumed
            )
            Log.d(
                "MyAppBarLayout",
                "onNestedScroll: dxConsumed = $dxConsumed dyConsumed = $dyConsumed dxUnconsumed = $dxUnconsumed dyUnconsumed = $dyUnconsumed"
            )

        }


        override fun onNestedFling(
            coordinatorLayout: CoordinatorLayout,
            child: AppBarLayout,
            target: View,
            velocityX: Float,
            velocityY: Float,
            consumed: Boolean
        ): Boolean {

            Log.d(
                "MyAppBarLayout",
                "onNestedFling: velocityX = $velocityX velocityY = $velocityY consumed = $consumed"
            )

            return super.onNestedFling(
                coordinatorLayout,
                child,
                target,
                velocityX,
                velocityY,
                consumed
            )
        }

        override fun onNestedPreFling(
            coordinatorLayout: CoordinatorLayout,
            child: AppBarLayout,
            target: View,
            velocityX: Float,
            velocityY: Float
        ): Boolean {

            Log.d(
                "MyAppBarLayout",
                "onNestedPreFling: velocityX = $velocityX velocityY = $velocityY"
            )

            return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY)

        }


    }
}
