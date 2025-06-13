Welcome to my java movie watchlist (back-end) apploication!
As requested here are my endpoints (in Json format):

{
  "contexts": {
    "MovieWatchlist": {
      "mappings": {
        "dispatcherServlets": {
          "dispatcherServlet": [
            {
              "predicate": "{GET [/actuator/mappings], produces [application/vnd.spring-boot.actuator.v3+json || application/vnd.spring-boot.actuator.v2+json || application/json]}",
              "handler": "Actuator web endpoint 'mappings'",
              "details": {
                "handlerMethod": {
                  "className": "org.springframework.boot.actuate.endpoint.web.servlet.AbstractWebMvcEndpointHandlerMapping.OperationHandler",
                  "name": "handle",
                  "descriptor": "(Ljakarta/servlet/http/HttpServletRequest;Ljava/util/Map;)Ljava/lang/Object;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "GET"
                  ],
                  "params": [],
                  "patterns": [
                    "/actuator/mappings"
                  ],
                  "produces": [
                    {
                      "mediaType": "application/vnd.spring-boot.actuator.v3+json",
                      "negated": false
                    },
                    {
                      "mediaType": "application/vnd.spring-boot.actuator.v2+json",
                      "negated": false
                    },
                    {
                      "mediaType": "application/json",
                      "negated": false
                    }
                  ]
                }
              }
            },
            {
              "predicate": "{GET [/actuator], produces [application/vnd.spring-boot.actuator.v3+json || application/vnd.spring-boot.actuator.v2+json || application/json]}",
              "handler": "Actuator root web endpoint",
              "details": {
                "handlerMethod": {
                  "className": "org.springframework.boot.actuate.endpoint.web.servlet.WebMvcEndpointHandlerMapping.WebMvcLinksHandler",
                  "name": "links",
                  "descriptor": "(Ljakarta/servlet/http/HttpServletRequest;Ljakarta/servlet/http/HttpServletResponse;)Ljava/util/Map;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "GET"
                  ],
                  "params": [],
                  "patterns": [
                    "/actuator"
                  ],
                  "produces": [
                    {
                      "mediaType": "application/vnd.spring-boot.actuator.v3+json",
                      "negated": false
                    },
                    {
                      "mediaType": "application/vnd.spring-boot.actuator.v2+json",
                      "negated": false
                    },
                    {
                      "mediaType": "application/json",
                      "negated": false
                    }
                  ]
                }
              }
            },
            {
              "predicate": "{GET [/api/movie]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#findAllMovies()",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "findAllMovies",
                  "descriptor": "()Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "GET"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{GET [/api/movie/releaseYear/{releaseYear}]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#findMovieByReleaseYear(int)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "findMovieByReleaseYear",
                  "descriptor": "(I)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "GET"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/releaseYear/{releaseYear}"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{PUT [/api/movie/{id}/director]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#updateMovieDirectorById(UUID, String)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "updateMovieDirectorById",
                  "descriptor": "(Ljava/util/UUID;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "PUT"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/{id}/director"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{ [/error]}",
              "handler": "org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController#error(HttpServletRequest)",
              "details": {
                "handlerMethod": {
                  "className": "org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController",
                  "name": "error",
                  "descriptor": "(Ljakarta/servlet/http/HttpServletRequest;)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [],
                  "params": [],
                  "patterns": [
                    "/error"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{PUT [/api/movie/{id}/watched]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#updateMovieWatchedById(UUID, boolean)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "updateMovieWatchedById",
                  "descriptor": "(Ljava/util/UUID;Z)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "PUT"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/{id}/watched"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{GET [/api/movie/filePaths/{filePaths}]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#findMovieByFilePaths(String)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "findMovieByFilePaths",
                  "descriptor": "(Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "GET"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/filePaths/{filePaths}"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{ [/error], produces [text/html]}",
              "handler": "org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController#errorHtml(HttpServletRequest, HttpServletResponse)",
              "details": {
                "handlerMethod": {
                  "className": "org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController",
                  "name": "errorHtml",
                  "descriptor": "(Ljakarta/servlet/http/HttpServletRequest;Ljakarta/servlet/http/HttpServletResponse;)Lorg/springframework/web/servlet/ModelAndView;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [],
                  "params": [],
                  "patterns": [
                    "/error"
                  ],
                  "produces": [
                    {
                      "mediaType": "text/html",
                      "negated": false
                    }
                  ]
                }
              }
            },
            {
              "predicate": "{GET [/api/movie/genre/{genre}]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#findMovieByGenre(String)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "findMovieByGenre",
                  "descriptor": "(Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "GET"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/genre/{genre}"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{DELETE [/api/movie/delete/{id}]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#deleteMovie(UUID)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "deleteMovie",
                  "descriptor": "(Ljava/util/UUID;)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "DELETE"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/delete/{id}"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{PUT [/api/movie/{id}/similarMovies]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#updateMovieSimilarMoviesById(UUID, String)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "updateMovieSimilarMoviesById",
                  "descriptor": "(Ljava/util/UUID;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "PUT"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/{id}/similarMovies"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{PUT [/api/movie/{id}/genre]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#updateMovieGenreById(UUID, String)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "updateMovieGenreById",
                  "descriptor": "(Ljava/util/UUID;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "PUT"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/{id}/genre"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{PUT [/api/movie/{id}/rating]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#updateMovieRatingById(UUID, int)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "updateMovieRatingById",
                  "descriptor": "(Ljava/util/UUID;I)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "PUT"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/{id}/rating"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{PUT [/api/movie/{id}/title]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#updateMovieTitleById(UUID, String)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "updateMovieTitleById",
                  "descriptor": "(Ljava/util/UUID;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "PUT"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/{id}/title"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{GET [/api/movie/rating/{rating}]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#findMovieByRating(int)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "findMovieByRating",
                  "descriptor": "(I)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "GET"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/rating/{rating}"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{POST [/api/movie]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#createPerson(MovieDTO)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "createPerson",
                  "descriptor": "(Lnl/inholland/appliedmathematics/oop3/moviewatchlist/model/MovieDTO;)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "POST"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{PUT [/api/movie/{id}/filePaths]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#updateMovieFilePathsById(UUID, String)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "updateMovieFilePathsById",
                  "descriptor": "(Ljava/util/UUID;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "PUT"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/{id}/filePaths"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{PUT [/api/movie/{id}/releaseYear]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#updateMovieReleaseYearById(UUID, int)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "updateMovieReleaseYearById",
                  "descriptor": "(Ljava/util/UUID;I)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "PUT"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/{id}/releaseYear"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{GET [/api/movie/similarMovies/{similarMovies}]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#findMovieBySimilarMovies(String)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "findMovieBySimilarMovies",
                  "descriptor": "(Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "GET"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/similarMovies/{similarMovies}"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{GET [/api/movie/title/{title}]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#findMovieByTitle(String)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "findMovieByTitle",
                  "descriptor": "(Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "GET"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/title/{title}"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{GET [/api/movie/watched/{watched}]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#findMovieByFileWatched(boolean)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "findMovieByFileWatched",
                  "descriptor": "(Z)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "GET"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/watched/{watched}"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "{GET [/api/movie/director/{director}]}",
              "handler": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController#findMovieByDirector(String)",
              "details": {
                "handlerMethod": {
                  "className": "nl.inholland.appliedmathematics.oop3.moviewatchlist.controller.MovieController",
                  "name": "findMovieByDirector",
                  "descriptor": "(Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;"
                },
                "requestMappingConditions": {
                  "consumes": [],
                  "headers": [],
                  "methods": [
                    "GET"
                  ],
                  "params": [],
                  "patterns": [
                    "/api/movie/director/{director}"
                  ],
                  "produces": []
                }
              }
            },
            {
              "predicate": "/webjars/**",
              "handler": "ResourceHttpRequestHandler [classpath [META-INF/resources/webjars/]]"
            },
            {
              "predicate": "/**",
              "handler": "ResourceHttpRequestHandler [classpath [META-INF/resources/], classpath [resources/], classpath [static/], classpath [public/], ServletContext [/]]"
            }
          ]
        },
        "servletFilters": [
          {
            "servletNameMappings": [],
            "urlPatternMappings": [
              "/*"
            ],
            "name": "requestContextFilter",
            "className": "org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter"
          },
          {
            "servletNameMappings": [],
            "urlPatternMappings": [
              "/*"
            ],
            "name": "webMvcObservationFilter",
            "className": "org.springframework.web.filter.ServerHttpObservationFilter"
          },
          {
            "servletNameMappings": [],
            "urlPatternMappings": [
              "/*"
            ],
            "name": "Tomcat WebSocket (JSR356) Filter",
            "className": "org.apache.tomcat.websocket.server.WsFilter"
          },
          {
            "servletNameMappings": [],
            "urlPatternMappings": [
              "/*"
            ],
            "name": "characterEncodingFilter",
            "className": "org.springframework.boot.web.servlet.filter.OrderedCharacterEncodingFilter"
          },
          {
            "servletNameMappings": [],
            "urlPatternMappings": [
              "/*"
            ],
            "name": "formContentFilter",
            "className": "org.springframework.boot.web.servlet.filter.OrderedFormContentFilter"
          }
        ],
        "servlets": [
          {
            "mappings": [
              "/"
            ],
            "name": "dispatcherServlet",
            "className": "org.springframework.web.servlet.DispatcherServlet"
          }
        ]
      }
    }
  }
}
