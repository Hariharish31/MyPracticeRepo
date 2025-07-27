import React from 'react';
import styles from './CohortDetails.module.css';

function CohortDetails({ name, startedOn, status, coach, trainer }) {
  const isOngoing = status.toLowerCase() === 'ongoing';

  return (
    <div className={styles.box}>
      <h3 style={{ color: isOngoing ? 'green' : 'blue' }}>{name}</h3>
      <dl>
        <dt>Started On</dt>
        <dd>{startedOn}</dd>

        <dt>Current Status</dt>
        <dd>{status}</dd>

        <dt>Coach</dt>
        <dd>{coach}</dd>

        <dt>Trainer</dt>
        <dd>{trainer}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
