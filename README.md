# Flix
Flix is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

[comment]: <> (📝 `NOTE - PASTE PART 2 SNIPPET HERE:` Paste the README template for part 2 of this assignment here at the top. This will show a history of your development process, which users stories you completed and how your app looked and functioned at each step.)

---

## Flix Part 1

### User Stories

#### REQUIRED (10pts)
- [x] (10pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [x] (2pts) Views should be responsive for both landscape/portrait mode.
    - [x] (1pt) In portrait mode, the poster image, title, and movie overview is shown.
    - [x] (1pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [x] (2pts) Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
- [x] (2pts) Improved the user interface by experimenting with styling and coloring.
- [ ] (2pts) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

### App Walkthough GIF

[comment]: <> (<img src="https://i.imgur.com/j89ZteX.gif" width=250><br>)
- Portrait mode
  <img src="https://github.com/yunijeong5/Flix/blob/master/filx_vertical.gif" width=250><br>

- Landscape mode
  <img src="https://github.com/yunijeong5/Flix/blob/master/flix_horizontal.gif" width=250><br>

### Notes
- Following the video walkthrough was simple enough, but I still don't think I could build this on my own. Hopefully I'll get used to it as I continue the course.
- Some Kotlin syntax were a bit confusing.
- Changing orientation mode was fun!

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids