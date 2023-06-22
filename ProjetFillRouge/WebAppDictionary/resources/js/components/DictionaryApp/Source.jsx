import React from "react";

// link icon
import { FiExternalLink } from "react-icons/fi";

const Source = ({ url }) => {
  return (
    <>
      {url && (
        <div className="flex items-center space-x-1 py-5">
          <h2 className="text-custom-blue"> Source : </h2>
          <a
            href={url}
            className="underline text-custom-blue px-1 space-x-1 flex items-center"
          >
            <span>{url[0]}</span>
            <FiExternalLink />
          </a>
        </div>
      )}
    </>
  );
};

export default Source;
