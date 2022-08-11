import axios from "axios";
import { useEffect, useState } from "react";
import MovieCard from "../../components/MovieCard";
import Pagination from "../../components/pagination";
import { MoviePage } from "../../types/movie";
import { BASE_URL } from "../../utils/request";

function Listing() {

  const [pageNumber,setPageNumber] = useState(0);
//forma
useEffect(() => {
    axios.get(`${BASE_URL}/movies?size=12&page=1`).then(response => {
    console.log(response.data);
    const data = response.data as MoviePage;
    setPageNumber(data.number);
  });
}, [])




  return (
    <>
    <p>{pageNumber}</p>
      <Pagination />
      <div className="cotainer">
        <div className="row">
          <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
            <MovieCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
            <MovieCard />
          </div><div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
            <MovieCard />
          </div><div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
            <MovieCard />
          </div><div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
            <MovieCard />
          </div>
        </div>
      </div>
    </>
  );
}

export default Listing;
