package raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.datasource.local.categories

import io.reactivex.Observable
import raf.rs.ispit.uros_nikolic_rn2117.foodrecipes.data.model.ui.Category

class HardcodedCategoryDataSource() : CategoryDataSource {

    override fun getCategories(): Observable<List<Category>> {
        return Observable.fromCallable {
            mutableListOf(
                Category(
                    1,
                    "Barbecue",
                    "https://www.firepitsuk.co.uk/wp-content/uploads/2019/11/FIREPITS-UK-LOCATION-182-1-of-1-copy-scaled.jpg"
                ),

                Category(
                    2,
                    "Breakfast",
                    "https://images.immediate.co.uk/production/volatile/sites/2/2018/08/Peanut-butter-pancakes-78d1366.jpg?quality=45&crop=387px,2234px,5100px,3398px&resize=620,413"
                ),

                Category(
                    3,
                    "Chicken",
                    "https://hips.hearstapps.com/hmg-prod/images/delish-190808-baked-drumsticks-0217-landscape-pf-1567089281.jpg"
                ),

                Category(
                    4,
                    "Beef",
                    "https://www.rachaelrayshow.com/sites/default/files/styles/video_1920x1080/public/images/2020-03/tenderloin-crop.jpg?itok=yCte9t8D"
                ),

                Category(
                    5,
                    "Brunch",
                    "https://marketnetwork.rs/wp-content/uploads/2017/09/food-salad-restaurant-person.jpg"
                ),

                Category(
                    6,
                    "Dinner",
                    "https://www.brit.co/media-library/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpbWFnZSI6Imh0dHBzOi8vYXNzZXRzLnJibC5tcy8yMjg1MDc4My9vcmlnaW4uanBnIiwiZXhwaXJlc19hdCI6MTYzNTIxMjI3M30.Q0yr3J418VfOKxU3PVjl8H7ZavMu1v1nKaB-XYd5lgo/image.jpg?width=980"
                ),

                Category(
                    7,
                    "Wine",
                    "https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fstatic.onecms.io%2Fwp-content%2Fuploads%2Fsites%2F9%2F2020%2F08%2F11%2Fbest-affordable-foreign-wines-FT-BLOG0820.jpg"
                ),

                Category(
                    8,
                    "Italian",
                    "https://hips.hearstapps.com/delish/assets/17/36/1504715566-delish-fettuccine-alfredo.jpg"
                )
            )
        }

    }

}