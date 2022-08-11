import { useParams } from "react-router-dom";
import FormCard from "../../FormCards";
function Form() {

  const params = useParams();

  return (
     <FormCard movieid={`${params.movieid}`}/>
  );
}

export default Form;
