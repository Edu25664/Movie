import axios from "axios";
import { useEffect, useState } from "react";
import MovieCard from "../../components/MovieCard";
import Pagination from "../../components/pagination";
import { MoviePage } from "../../types/movie";
import { BASE_URL } from "../../utils/request";

function Listing() {
  const [pageNumber, setPageNumber] = useState(0);
  const [page, setPage] = useState<MoviePage>({
    content: [],
    last: true,
    totalPages: 0,
    totalElements: 0,
    size: 12,
    number: 0,
    first: true,
    numberOfElements: 0,
    empty: true,
  });
  //forma
  useEffect(() => {
    axios
      .get(`${BASE_URL}/movies?size=12&page=${pageNumber}&sort=id`)
      .then((response) => {
        const data = response.data as MoviePage;
        setPage(data);
      });
  }, [pageNumber]);

  const handlePageChange = (newPagenumber : number) => {
     setPageNumber(newPagenumber);
  }
  return (
    <>
      <Pagination page = {page} oneChange ={handlePageChange}/>
      <div className="cotainer">
        <div className="row">
          {page.content.map((movie) => (
            <div key={movie.id} className="col-sm-6 col-lg-4 col-xl-3 mb-3">
              <MovieCard movie={movie} />
            </div>
          ))}
        </div>
      </div>
    </>
  );
}

export default Listing;
